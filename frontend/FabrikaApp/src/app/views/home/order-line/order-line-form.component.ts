import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderLineRestControllerService } from '../../../../../libs/openapi/src/api/orderLineRestController.service';

@Component({
  selector: 'app-order-line-form',
  templateUrl: './order-line-form.component.html',
  styleUrls: ['./order-line-form.component.css']
})
export class OrderLineFormComponent implements OnInit {

  object: any = {}; // Initialize object with empty object

  constructor(private route: Router,private _service: OrderLineRestControllerService ) { }
  id: any;

  ngOnInit() {
    this.id = history.state.id;
    if (this.id != null) {
      this.object.id = this.id;
      this.load();
    }
  }
  save(object: any) {
  
    this._service.save4(object).subscribe((res: any) => {
      if (res != null) {
        this.route.navigate(['/Adm/OrderLineList'])
      } else {
        alert("Something went wrong!")
      }
    });
  }

  load(){
    this._service.load5(this.id).subscribe((res: any) => {   
      this.object = res;
    });
  }

  cancel() {
    this.route.navigate(['/Adm/OrderLineList'])
  }
}
