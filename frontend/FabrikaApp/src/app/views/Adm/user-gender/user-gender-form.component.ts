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
  id: any;

  ngOnInit() {
    this.id = history.state.id;
    if (this.id != null) {
      this.object.id = this.id;
      this.load();
    }
  }

  save(object: any) {
    this.toggleToast();
    this._service.save2(object).subscribe((res: any) => {
      if (res != null) {
        this.route.navigate(['/Adm/UserGenderList'])
      } else {
        alert("Something went wrong!")
      }
    });
  }

  load(){
    this._service.load2(this.id).subscribe((res: any) => {   
      this.object = res;
    });
  }

  cancel() {
    this.route.navigate(['/Adm/UserGenderList'])
  }

  position = 'top-center';
  visible = false;
  percentage = 0;

  toggleToast() {
    this.visible = !this.visible;
  }

  onVisibleChange($event: boolean) {
    this.visible = $event;
    this.percentage = !this.visible ? 0 : this.percentage;
  }

  onTimerChange($event: number) {
    this.percentage = $event * 50;
  }
}