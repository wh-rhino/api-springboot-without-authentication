package cl.ionix.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TransformacionUtil {

	private TransformacionUtil() {
	}
	
	/**
	 * Metodo para cifrar rut a enviar a url sandbox.
	 * 
	 * @param rutUsuario
	 * @return param
	 */
	public static String cifradoDES(String rutUsuario) {
		String param = null;
		try {
			SecretKeyFactory secret = SecretKeyFactory.getInstance("DES");
			DESKeySpec key = new DESKeySpec(rutUsuario.getBytes());
			SecretKey secretKey = secret.generateSecret(key);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] cleartext = rutUsuario.getBytes("UTF8");
			byte[] encrypted = cipher.doFinal(cleartext);
			param = Base64.getEncoder().encode(encrypted).toString();
		} catch (NoSuchAlgorithmException | InvalidKeyException | InvalidKeySpecException | NoSuchPaddingException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException e) {
			log.info("cifradoDES Exception : " + e.getCause());
		}
		return param;
	}
}
