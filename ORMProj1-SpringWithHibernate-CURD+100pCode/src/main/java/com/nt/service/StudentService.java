package com.nt.service;

import java.util.List;

import com.nt.dto.SpStudentDTO;

public interface StudentService {
   public  SpStudentDTO getStudentByNo(int no);
   public String register(SpStudentDTO dto);
   public  String changeAddrs(int sno,String newAddrs);
   public String fireStudent(int sno);
   public List<SpStudentDTO> getStudentsByAddrs(String addrs);
   public List<SpStudentDTO> getStudentsByNames(String name1,String name2);
   public List<SpStudentDTO> getStudentsByRange(int start,int end);
   public List<SpStudentDTO> fetchStudentsByRange(int start,int end);
   public String  deleteStudentsByAddrs(String addrs);
}
