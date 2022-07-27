package com.github.kop.plugin.otp;

import java.io.Serializable;

public interface IdInterface<T extends Serializable> {
    T getId();
}
