package org.corodiak.l4jspring.util;

import org.springframework.stereotype.Component;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.LongPasswordStrategies;

@Component
public class BCryptProvider {
	public String encrypt(String plain) {
		return BCrypt.with(LongPasswordStrategies.hashSha512(BCrypt.Version.VERSION_2A)).hashToString(12, plain.toCharArray());
	}

	public boolean match(String plain, String cipher) {
		BCrypt.Result result = BCrypt.verifyer(BCrypt.Version.VERSION_2A, LongPasswordStrategies.hashSha512(
			BCrypt.Version.VERSION_2A)).verify(plain.toCharArray(), cipher);
		return result.verified;
	}
}
