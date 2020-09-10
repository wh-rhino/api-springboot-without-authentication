package cl.ionix.util;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.apache.commons.codec.binary.Base64;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TransformacionUtil {

	private static final String DESEDE_ENCRYPTION_SCHEME = "DES";
	
	TransformacionUtil() {
	}
	
	public static String cifradoDES(String param) {
		String result = null;
		try {
			String key = "DeprecatedDes";
			byte[] array = key.getBytes(StandardCharsets.UTF_8);
			KeySpec ks = new DESKeySpec(array);
			SecretKeyFactory skf = SecretKeyFactory.getInstance(DESEDE_ENCRYPTION_SCHEME);
			SecretKey secretKey = skf.generateSecret(ks);
			
			// TODO: Noncompliant: DES works with 56-bit keys allow attacks via exhaustive search
			Cipher cipher = Cipher.getInstance(DESEDE_ENCRYPTION_SCHEME);
			
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] text = param.getBytes(StandardCharsets.UTF_8);
			byte[] encrypted = cipher.doFinal(text);
			result = new String(Base64.encodeBase64(encrypted));			
		} catch (InvalidKeyException | IllegalBlockSizeException | 
					BadPaddingException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException e) {
			log.error("cifradoDES : ", e);
		}
		return result;
	}
}
