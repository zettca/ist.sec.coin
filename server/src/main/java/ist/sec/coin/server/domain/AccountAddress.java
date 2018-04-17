package ist.sec.coin.server.domain;

import ist.sec.coin.server.security.CryptoUtils;

import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;

public class AccountAddress {
    private String fingerprint;

    public AccountAddress(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public AccountAddress(Certificate cert) throws NoSuchAlgorithmException {
        this.fingerprint = CryptoUtils.getCertificateFingerprint(cert);
    }

    public String getFingerprint() {
        return fingerprint;
    }

    @Override
    public String toString() {
        return fingerprint;
    }

    @Override
    public boolean equals(Object o) {
        return this.fingerprint.equals(o.toString());
    }
}