import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { UploadBookContainerComponent } from './upload-book-container/upload-book-container.component';



const routes: Routes = [];
export const appRouting = RouterModule.forRoot(routes);
@NgModule({
  imports: [RouterModule.forRoot(routes),
  CommonModule,
  
],
  exports: [RouterModule],
  declarations:[]
})
export class AppRoutingModule { }
