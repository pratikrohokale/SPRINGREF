package com.nt.dao;

import java.util.List;

import com.nt.domain.SpStudentHLO;

public interface StudentDAO {
	public SpStudentHLO  findStudentByNo(int no);
    public int  insert(SpStudentHLO hlo);
    public  int  update(int sno,String newAddrs);
    public  int remove(int sno);
    public  List<SpStudentHLO>  findStudentsByAddrs(String addrs);
    public  List<SpStudentHLO>  findStudentsByNames(String name1,String name2);
    public  List<SpStudentHLO>  findStudentByRange(int start,int end);
    public  List<SpStudentHLO>  findStudentsByRange(int start,int end);
    public  int deleteStudentsByAddrs(String addrs);
}
