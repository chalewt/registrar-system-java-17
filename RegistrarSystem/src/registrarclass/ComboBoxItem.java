/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrarclass;

import java.util.ArrayList;
import javax.swing.JComboBox;
import registrarlib.Curriculum;
import registrarlib.Department;
import registrarlib.Faculty;

/**
 *
 * @author ChalewT
 */
public class ComboBoxItem {

    private final int codeValue;
    private final String displayText;

    public ComboBoxItem(int code, String text) {
        this.codeValue = code;
        this.displayText = text;

    }

    /**
     * @return the codeValue
     */
    public int getCodeValue() {
        return codeValue;
    }

    /**
     * @return the displayText
     */
    public String getDisplayText() {
        return displayText;
    }

    //Override the toString methods of Combo Box control
    //Give the required value to display
    @Override
    public String toString() {
        return this.displayText;
    }

    //Fill combobox items
    public static void loadFaculty(JComboBox cmbFaculty) {
        try {
            ArrayList<Faculty> facultyList = new ArrayList<Faculty>();
            Faculty faculty = new Faculty();
            facultyList = faculty.getFacultyList();
            for (Faculty facultyInList : facultyList) {
                ComboBoxItem facultyItem = new ComboBoxItem(facultyInList.getCode(), facultyInList.getName());
                cmbFaculty.addItem(facultyItem);
            }
        } catch (Exception ex) {
        }
    }

    public static void loadDepartment(JComboBox cmbDepartment, int facultyCode) {
        try {
            cmbDepartment.removeAllItems();
            ArrayList<Department> deptList = new ArrayList<Department>();
            Department dept = new Department();
            deptList = dept.getDepartmentList(facultyCode);
            for (Department deptInList : deptList) {
                ComboBoxItem deptItem = new ComboBoxItem(deptInList.getCode(), deptInList.getName());
                cmbDepartment.addItem(deptItem);
            }
        } catch (Exception ex) {
        }
    }

    public static void loadCurriculum(JComboBox cmbCurriculum, int deptCode) throws Exception {
        cmbCurriculum.removeAllItems();
        ArrayList<Curriculum> currList = new ArrayList<Curriculum>();
        Curriculum curr = new Curriculum();
        currList = curr.getCurriculumList(deptCode);
        for (Curriculum currInList : currList) {
            ComboBoxItem deptItem = new ComboBoxItem(currInList.getCode(), currInList.getNomc() +":"+ currInList.getVersion());
            cmbCurriculum.addItem(deptItem);
        }
    }
    
      public static void loadOwnerDepartment(JComboBox cmbOwnerDepartment) {
         try {
            cmbOwnerDepartment.removeAllItems();
            ArrayList<Department> deptList = new ArrayList<Department>();
            Department dept = new Department();
            deptList = dept.getDepartmentList();
            for (Department deptInList : deptList) {
                ComboBoxItem deptItem = new ComboBoxItem(deptInList.getCode(), deptInList.getName());
                cmbOwnerDepartment.addItem(deptItem);
            }
        } catch (Exception ex) {
        }
    }

}
