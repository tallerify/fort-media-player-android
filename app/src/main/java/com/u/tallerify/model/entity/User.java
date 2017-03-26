package com.u.tallerify.model.entity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.u.tallerify.model.Gender;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Model for the user
 *
 * Created by saguilera on 3/12/17.
 */
public class User extends Entity implements Serializable {

    private @NonNull String userName;
    private @NonNull String email;
    private @NonNull Date birthday;
    private @NonNull List<String> pictures;
    private @NonNull List<User> contacts;

    protected User() {
        super();
    }

    protected User(@NonNull Builder builder) {
        super(builder);
        userName = builder.name;
        email = builder.email;
        birthday = builder.birthday;
        pictures = builder.pictures;
        contacts = builder.contacts;
    }

    public @NonNull Date birthday() {
        return birthday;
    }

    public @NonNull List<String> pictures() {
        return pictures;
    }

    public @NonNull String email() {
        return email;
    }

    public @NonNull String name() {
        return userName;
    }

    public @NonNull List<User> contacts() {
        return contacts;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        final User user = (User) o;

        if (!userName.equals(user.userName)) {
            return false;
        }
        if (!email.equals(user.email)) {
            return false;
        }
        if (!birthday.equals(user.birthday)) {
            return false;
        }
        if (!contacts.equals(user.contacts)) {
            return false;
        }
        return pictures.equals(user.pictures);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + pictures.hashCode();
        result = 31 * result + contacts.hashCode();
        return result;
    }

    public static class Builder extends Entity.Builder<User> {

        @Nullable String name;
        @Nullable String email;
        @Nullable Date birthday;
        @Nullable List<User> contacts;
        @Nullable List<String> pictures;

        public Builder() {
            super();
        }

        public Builder(@NonNull User user) {
            super(user);
            name(user.name());
            email(user.email());
            birthday(user.birthday());
            pictures(user.pictures());
            contacts(user.contacts());
        }

        public final @NonNull Builder birthday(@NonNull final Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public final @NonNull Builder email(@NonNull final String email) {
            this.email = email;
            return this;
        }

        public final @NonNull Builder name(@NonNull final String name) {
            this.name = name;
            return this;
        }

        public final @NonNull Builder pictures(@NonNull final List<String> pictures) {
            this.pictures = pictures;
            return this;
        }

        public final @NonNull Builder contacts(@NonNull final List<User> contacts) {
            this.contacts = contacts;
            return this;
        }

        @Override
        public @NonNull User build() {
            if (buildable())
                return new User(this);
            else throw new IllegalStateException("Builder has an illegal state");
        }

        @Override
        public boolean buildable() {
            boolean buildable = super.buildable();
            buildable &= name != null;
            buildable &= email != null;
            buildable &= birthday != null;
            buildable &= pictures != null;
            buildable &= contacts != null;
            return buildable;
        }

    }

}