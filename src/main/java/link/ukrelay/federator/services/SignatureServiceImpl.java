package link.ukrelay.federator.services;

import link.ukrelay.federator.exceptions.FatalException;
import link.ukrelay.federator.exceptions.InvalidSignatureException;
import link.ukrelay.federator.model.Signature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Service
public class SignatureServiceImpl implements SignatureService {

    private KeyPair key;

    public KeyPair getKey() {
        if (this.key == null) {
            log.warn("Private Key Not Found. Generating.");
            this.key =  generateKey();
        }
        return this.key;
    }

    protected KeyPair generateKey() {
        try {
            var generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(4096);
            return generator.generateKeyPair();

        } catch (NoSuchAlgorithmException ex) {
            throw new FatalException("Could not create RSA key", ex);
        }

    }

    public Signature parseSignature(final String value) {
        try {
            var signature = new Signature();
            var parts = value.split(",");
            signature.setKeyId(parts[0]);
            signature.setHeaders(parts[1]);
            signature.setSignature(parts[2]);
            return new Signature();
        } catch (Exception ex) {
            throw new InvalidSignatureException(ex);
        }

    }

}
