package org.corodiak.l4jspring;

import org.corodiak.l4jspring.util.BCryptProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {BCryptProvider.class})
public class BCryptTest {

	@Autowired
	BCryptProvider bCryptProvider;

	@Test
	public void test() {
		String plain = "1234";
		String dummy = "asdf";
		String cipher = bCryptProvider.encrypt(plain);
		Assertions.assertTrue(bCryptProvider.match(plain, cipher));
		Assertions.assertFalse(bCryptProvider.match(dummy, cipher));
	}

}
