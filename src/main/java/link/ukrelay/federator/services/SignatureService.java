package link.ukrelay.federator.services;

import link.ukrelay.federator.model.Signature;

import java.security.KeyPair;

public interface SignatureService {
    KeyPair getKey();
    Signature parseSignature(String value);
}
