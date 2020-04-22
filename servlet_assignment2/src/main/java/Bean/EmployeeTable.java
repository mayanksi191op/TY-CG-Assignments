package Bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@SuppressWarnings("serial")
@Table
public class EmployeeTable implements Serializable {
	
	@Id
	@Column
	private Integer employee_id;
	@Column
	private String name;
	@Column
	private String dob;
	@Column
	private String joining_date;
	@Column
	private Integer dept_id;
	@Column
	private String designation;
	@Column
	private Double salary;
	@Column
	private Integer manager_id;
	@Column
	private String email;
	@Column
	private long mobile;
	@Column
	private String password;
	
	
}	
