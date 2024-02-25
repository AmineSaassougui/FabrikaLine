import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ItemRestControllerService } from 'libs/openapi/src';

@Component({
  selector: 'app-item-form',
  templateUrl: './item-form.component.html',
  styleUrls: ['./item-form.component.css']
})
export class ItemFormComponent implements OnInit {
  object: any = {}; // Initialize object with empty object
  ok = true;
  categoryId : number =0;
  constructor(private route: Router, private _service: ItemRestControllerService) { }
  id: any;

  ngOnInit() {
    this.id = history.state.id;
    if (this.id != null) {
      this.object.id = this.id;
      this.load();
    }
  }

  save(object: any) {
    this._service.save(this.categoryId, object).subscribe((res: any) => {
      if (res != null) {
        this.route.navigate(['/Adm/ItemList'])
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
    this.route.navigate(['/Adm/ItemList'])
  }
}
