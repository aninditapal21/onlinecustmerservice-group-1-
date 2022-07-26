import { Component, OnInit } from '@angular/core';
import { Department } from '../model/department';
import { DepartmentserviceService } from '../service/departmentservice.service';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css']
})
export class DepartmentComponent implements OnInit {
  department:Department=new Department();
  constructor(private ds:DepartmentserviceService) { }

  ngOnInit() {
  }
  public addDepartment(){
    console.log(this.department);
    this.ds.addDepartment(this.department).subscribe(response=>{
      alert("department added");
      window.location.reload();
    }) 
  }

}
