import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageTasksComponent } from './page-tasks.component';

const routes: Routes = [
  {
    path: '',
    component: PageTasksComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PageTasksRoutingModule {}
