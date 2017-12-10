package com.bekey.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by bekey on 2017/12/9.
 */
@Entity
public class SysRole {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
}
