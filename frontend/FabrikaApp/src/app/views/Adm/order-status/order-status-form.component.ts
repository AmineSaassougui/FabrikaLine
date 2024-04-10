import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {OrderStatusRestControllerService} from "../../../../../libs/openapi/src";

@Component({
  selector: 'app-order-status-form',
  templateUrl: './order-status-form.component.html',
  styleUrls: ['./order-status-form.component.css']
})
export class OrderStatusFormComponent implements OnInit {

  object: any = {}; // Initialize object with empty object

  constructor(private route: Router, private _service: OrderStatusRestControllerService) { }
  id: any;

  ngOnInit() {
    this.id = history.state.id;
    if (this.id != null) {
      this.object.id = this.id;
      this.load();
    }
  }

  save(object: any) {
    this._service.saveOrderStatus(object).subscribe((res: any) => {
      if (res != null) {
        this.route.navigate(['/Adm/OrderStatusList'])
      } else {
        alert("Something went wrong!")
      }
    });
  }

  load(){
    this._service.loadOrderStatus(this.id).subscribe((res: any) => {
      this.object = res;
    });
  }

  cancel() {
    this.route.navigate(['/Adm/OrderStatusList'])
  }
}
