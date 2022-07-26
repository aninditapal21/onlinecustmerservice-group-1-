import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../model/customer';
import { CustomerserviceService } from '../service/customerservice.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customer: Customer = new Customer();
  constructor(private router: ActivatedRoute, private cs:CustomerserviceService, private r: Router) { }

  ngOnInit() {
  }
  public addCustomer() {
    console.log(this.customer);
    this.cs.addCustomer(this.customer).subscribe((p) => {
      alert("customer added");
      this.r.navigate(['login']);
    }
    );
  }

}
