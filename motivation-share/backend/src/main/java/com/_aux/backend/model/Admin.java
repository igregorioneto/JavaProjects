package com._aux.backend.model;

import com._aux.backend.enums.AdminLevel;
import com._aux.backend.enums.AdminTitle;
import com._aux.backend.enums.UserRole;
import jakarta.persistence.*;

import java.util.Collections;

@Entity
@Table(name = "tb_users_admin")
public class Admin extends User<UserRole> {
    @Enumerated(EnumType.STRING)
    @Column
    private AdminTitle title;
    @Enumerated(EnumType.STRING)
    @Column
    private AdminLevel level;
    public Admin() {
        setRoles(Collections.singleton(UserRole.ADM));
    }

    public AdminTitle getTitle() {
        return title;
    }

    public void setTitle(AdminTitle title) {
        this.title = title;
    }

    public AdminLevel getLevel() {
        return level;
    }

    public void setLevel(AdminLevel level) {
        this.level = level;
    }
}
