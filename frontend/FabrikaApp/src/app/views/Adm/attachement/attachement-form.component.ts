import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AttachmentRestControllerService } from '../../../../../libs/openapi/src/api/attachmentRestController.service';

@Component({
  selector: 'app-attachement-form',
  templateUrl: './attachement-form.component.html',
})
export class AttachementFormComponent implements OnInit {
  object: any = {}; // Initialize object with empty object
  categoryId: number = 1;
  parentId: any;
  constructor(private route: Router, private _service: AttachmentRestControllerService) { }
  id: any;

  ngOnInit() {
    this.parentId = history.state.parentId;

    this.id = history.state.id;
    if (this.id != null) {
      this.object.id = this.id;
      this.load();
    }
  }

  save(object: any) {
    object.parentId = this.parentId;
    this.toggleToast();
    this._service.saveAttachment(this.categoryId, object).subscribe((res: any) => {
      if (res != null) {
        this.route.navigate(['/Adm/AttachementList'])
      } else {
        alert("Something went wrong!")
      }
    });
  }

  load() {
    this._service.loadAttachment(this.id).subscribe((res: any) => {
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

  //Attachement : 
  base64String: string = "";
  fileName: string= "";
  fileExtension: string | undefined ;

  onFileSelected(event: any) {
    const file: File = event.target.files[0];
    this.object.description = file.name;
    this.object.extension = this.getFileExtension(file);  
    this.convertToBase64(file);
  }

  convertToBase64(file: File) {
    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = () => {
      this.base64String = reader.result as string;
      this.object.attachedFile =this.base64String;
    };
    reader.onerror = (error) => {
      console.error('Error converting file to base64:', error);
    };
  }

  getFileExtension(file: File): string | undefined {
    return file.name.split('.').pop();
  }

//   //Attachement : 
// fileName: string = "";
// fileExtension: string | undefined;
// fileContent: Uint8Array | undefined; // Use Uint8Array to store byte data

// onFileSelected(event: any) {
//   const file: File = event.target.files[0];
//   this.object.description = file.name;
//   this.object.extension = this.getFileExtension(file);  
//   this.readFileContent(file);
// }

// readFileContent(file: File) {
//   const reader = new FileReader();
//   reader.readAsArrayBuffer(file); // Read file content as an ArrayBuffer
//   reader.onload = () => {
//     this.fileContent = new Uint8Array(reader.result as ArrayBuffer);
//     this.object.attachedFile =this.fileContent;
//   };
//   reader.onerror = (error) => {
//     console.error('Error reading file content:', error);
//   };
// }

// getFileExtension(file: File): string | undefined {
//   return file.name.split('.').pop();
// }
// downloadFile() {
//   if (this.fileContent) {
//     const blob = new Blob([this.fileContent], { type: 'application/octet-stream' });
//     const url = window.URL.createObjectURL(blob);
//     const link = document.createElement('a');
//     link.href = url;
//     link.download = this.fileName;
//     link.click();
//     window.URL.revokeObjectURL(url);
//   } else {
//     console.error('File content is undefined');
//   }
// }



}