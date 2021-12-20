package ru.coursework.demo1.Domain;

import lombok.Data;

@Data
public class MasterForm {
    private long master_id;
    private String master_name;
    private String speciality;

    public Master toMaster (){
        Master master = new Master();
        master.setMaster_id(master_id);
        master.setMaster_name(master_name);
        master.setSpeciality(speciality);

        return master;
    }
}
