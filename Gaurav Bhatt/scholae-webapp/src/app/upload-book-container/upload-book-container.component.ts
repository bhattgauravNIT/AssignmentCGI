import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';



@Component({
  selector: 'app-upload-book-container',
  templateUrl: './upload-book-container.component.html',
  styleUrls: ['./upload-book-container.component.css']
})
export class UploadBookContainerComponent implements OnInit {
  UploadForm : FormGroup;

  constructor() { }

  ngOnInit() {
    this.UploadForm = new FormGroup(
      {
        Title: new FormControl('',[Validators.required]),
        Author : new FormControl('',[Validators.required]),
        Description : new FormControl('',[Validators.required,Validators.maxLength(80)]),
        Publisher : new FormControl('',[Validators.required]),
        TotalPage : new FormControl('',[Validators.required]),
        Genre : new FormControl('',[Validators.required])
      }
    );

  }
  UploadBook() {
    console.log("formValue", this.UploadForm.value);
    this.UploadForm.reset();
  }
 

}
