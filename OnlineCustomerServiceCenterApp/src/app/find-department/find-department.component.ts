import { Component, OnInit } from '@angular/core';
import { Department } from '../model/department';
import { DepartmentserviceService } from '../service/departmentservice.service';

@Component({
  selector: 'app-find-department',
  templateUrl: './find-department.component.html',
  styleUrls: ['./find-department.component.css']
})
export class FindDepartmentComponent implements OnInit {
  departmentId:number;
  department:Department;
  constructor(private ds:DepartmentserviceService) { }

  ngOnInit() {
  }
  public searchDept(){
    //this.department.departmentId=this.departmentId;
    this.ds.extractdeptById(this.departmentId).subscribe(response=>{
      this.department=response;
      console.log(response);
    })
  }

}
