import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { CountryListComponent } from './country-list/country-list.component';

const routes: Routes = [
  {
    path: 'UserList',
    component: UserListComponent,
    data: {
      title: 'Utilisateur'
    }
  },
  {
    path: 'CountryList',
    component: CountryListComponent,
    data: {
      title: 'Pays'
    }
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdministrationRoutingModule {
}
