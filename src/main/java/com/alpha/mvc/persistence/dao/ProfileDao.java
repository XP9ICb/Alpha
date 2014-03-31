package com.alpha.mvc.persistence.dao;

import com.alpha.mvc.persistence.domain.Profile;

public interface ProfileDao {
    public Profile getProfile(int id);
    public void update(Profile profile);
}
