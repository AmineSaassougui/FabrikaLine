import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AttachmentRestControllerService } from '../../../../../libs/openapi/src/api/attachmentRestController.service';

@Component({
  selector: 'app-attachement-form',
  templateUrl: './attachement-form.component.html',
})
export class AttachementFormComponent implements OnInit {
  object: any = {}; // Initialize object with empty object
  categoryId : number =0;

  constructor(private route: Router, private _service: AttachmentRestControllerService) { }
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
    this._service.save1(this.categoryId, object).subscribe((res: any) => {
      if (res != null) {
        this.route.navigate(['/Adm/AttachementList'])
      } else {
        alert("Something went wrong!")
      }
    });
  }

  load(){
    this._service.load10(this.id).subscribe((res: any) => {   
      this.object = res;
    });
  }

  cancel() {
    this.route.navigate(['/Adm/AttachementList'])
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