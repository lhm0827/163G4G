package com.qhit.lh.g4.lhm.t1.basedao;

import java.util.List;

import com.qhit.lh.g4.lhm.t1.bean.User;

public interface BaseDao {
public void add(User user);
public void delete(User user);
public void update(User user);
public List<Object> queryAll(String  tableName);
}
