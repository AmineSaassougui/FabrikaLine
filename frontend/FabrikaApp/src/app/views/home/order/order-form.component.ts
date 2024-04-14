import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderControllerService } from './../../../../../libs/openapi/src/api/orderController.service';

@Component({
  selector: 'app-order-form',
  templateUrl: './order-form.component.html',
  styleUrls: ['./order-form.component.css']
})
export class OrderFormComponent implements OnInit {

  object: any = {}; // Initialize object with empty object

  constructor(private route: Router, private _service: OrderControllerService) { }
  id: any;

  ngOnInit() {
    this.id = history.state.id;
    if (this.id != null) {
      this.object.id = this.id;
      this.load();
    }
  }

  save(object: any) {
  
    // this._service.saveOrder(object).subscribe((res: any) => {
    //   if (res != null) {
    //     this.route.navigate(['/Adm/OrderList'])
    //   } else {
    //     alert("Something went wrong!")
    //   }
    // });
  }

  load(){
    this._service.loadOrder(this.id).subscribe((res: any) => {   
      this.object = res;
    });
  }

  cancel() {
    this.route.navigate(['/Adm/OrderList'])
  }
}
