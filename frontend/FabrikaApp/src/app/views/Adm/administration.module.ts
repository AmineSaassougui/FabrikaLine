import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CardModule, GridModule } from '@coreui/angular';
import { IconModule } from '@coreui/icons-angular';
import { AdministrationComponent } from './administration.component';
import { AdministrationRoutingModule } from './administration-routing.module';
import { UserListComponent } from './user-list/user-list.component';

@NgModule({
  imports: [
    CardModule,
    GridModule,
    IconModule,
    CommonModule,
    AdministrationRoutingModule
  ],
  declarations: [
    AdministrationComponent, UserListComponent
  ]
})
export class AdministrationModule {
}
