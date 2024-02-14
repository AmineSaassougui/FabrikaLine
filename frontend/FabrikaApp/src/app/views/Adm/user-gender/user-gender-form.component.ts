import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserGender, UserGenderRestControllerService } from 'libs/openapi/src';

@Component({
  selector: 'app-user-gender-form',
  templateUrl: './user-gender-form.component.html',
})
export class UserGenderFormComponent implements OnInit {
  object: any = {}; // Initialize object with empty object

  constructor(private route: Router, private _service: UserGenderRestControllerService) { }

  ngOnInit() {
    // You can initialize any other properties or perform other setup logic here if needed
  }

  save(object: any) {
    this._service.save2(object).subscribe((res: any) => {
      if (res != null) {
        alert("Added with success")
        this.route.navigate(['/Adm/UserGenderList'])
      } else {
        alert("Something went wrong!")
      }
    });
  }

  cancel() {
    this.route.navigate(['/Adm/UserGenderList'])
  }
}