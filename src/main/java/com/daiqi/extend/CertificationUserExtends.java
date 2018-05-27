package com.daiqi.extend;

import com.daiqi.entity.CertificationUser;

public class CertificationUserExtends extends CertificationUser {
    private UserExtends userExtends;

    public UserExtends getUserExtends() {
        return userExtends;
    }

    public void setUserExtends(UserExtends userExtends) {
        this.userExtends = userExtends;
    }
}
