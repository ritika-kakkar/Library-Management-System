package com.library.service;

import com.library.controller.model.request.BookData;
import com.library.controller.model.request.StudentData;
import net.sf.json.JSONException;

public interface StudentService {

    public String addStudent(StudentData studentData) throws JSONException;


}
