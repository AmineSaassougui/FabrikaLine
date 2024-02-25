import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ItemCategoryRestControllerService } from 'libs/openapi/src';

@Component({
  selector: 'app-item-category-form',
  templateUrl: './item-category-form.component.html',
  styleUrls: ['./item-category-form.component.css']
})
export class ItemCategoryFormComponent implements OnInit {

  object: any = {}; // Initialize object with empty object

  constructor(private route: Router, private _service: ItemCategoryRestControllerService) { }
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
        this.route.navigate(['/Adm/ItemCategoryList'])
      } else {
        alert("Something went wrong!")
      }
    });
  }

  load(){
    // this._service.(this.id).subscribe((res: any) => {   
    //   this.object = res;
    // });
  }

  cancel() {
    this.route.navigate(['/Adm/ItemCategoryList'])
  }


}
