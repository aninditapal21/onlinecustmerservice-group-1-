import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { CustomerComponent } from './customer/customer.component';
import { CustomerviewissueComponent } from './customerviewissue/customerviewissue.component';
import { DepartmentComponent } from './department/department.component';
import { FindCustmerComponent } from './find-custmer/find-custmer.component';
import { FindDepartmentComponent } from './find-department/find-department.component';
import { FindIssueComponent } from './find-issue/find-issue.component';
import { FindOperatorComponent } from './find-operator/find-operator.component';
import { ForgotPassWordComponent } from './forgot-pass-word/forgot-pass-word.component';
import { HomeComponent } from './home/home.component';
import { IntimationMailComponent } from './intimation-mail/intimation-mail.component';
import { IssueComponent } from './issue/issue.component';
import { LockCustomerComponent } from './lock-customer/lock-customer.component';
import { LoginComponentComponent } from './login-component/login-component.component';
import { LogoutComponent } from './logout/logout.component';
import { MailComponent } from './mail/mail.component';
import { MenuComponent } from './menu/menu.component';
import { OperatorMenuComponent } from './operator-menu/operator-menu.component';
import { OperatorComponent } from './operator/operator.component';
import { PassWordMailComponent } from './pass-word-mail/pass-word-mail.component';
import { UpdateFormComponent } from './update-form/update-form.component';
import { UpdateIssueFormComponent } from './update-issue-form/update-issue-form.component';
import { UpdateOperatorComponent } from './update-operator/update-operator.component';
import { ViewCustomerComponent } from './view-customer/view-customer.component';
import { ViewDepartmentComponent } from './view-department/view-department.component';
import { ViewIssueComponent } from './view-issue/view-issue.component';
import { ViewOperatorComponent } from './view-operator/view-operator.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [{path:"",component:HomeComponent},
{path:"login",component:LoginComponentComponent},
{path:"Menu/:name",component:MenuComponent},
{path:"createDepartment",component:DepartmentComponent},
{path:"logout",component:HomeComponent},
{path:"viewDepartment",component:ViewDepartmentComponent},
{path:"updateForm/:deptId",component:UpdateFormComponent},
{path:"findDepartment",component:FindDepartmentComponent},
{path:"operator",component:OperatorMenuComponent},
{path:"addCustomerIssue",component:IssueComponent},
{path:"viewCustomerIssue",component:ViewIssueComponent},
{path:"updatedIssueForm/:optId",component:UpdateIssueFormComponent},
{path:"findCustomer",component:FindCustmerComponent},
{path:"viewCustomer",component:ViewCustomerComponent},
{path:"sendModifyMail",component:MailComponent},
{path:"lockCustomer/:optId",component:LockCustomerComponent},
{path:"sendIntimationMail",component:IntimationMailComponent},
{path:"Viewoperator",component:ViewOperatorComponent},
{path:"Findoperator",component:FindOperatorComponent},
{path:"Createoperator",component:OperatorComponent},
{path:"updateOperator/:deptId",component:UpdateOperatorComponent},
{path:"customer",component:CustomerComponent},
{path:"welcome/:name",component:WelcomeComponent},
{path:"ViewIssue",component:CustomerviewissueComponent},
{path:"findissuebyid",component:FindIssueComponent},
{path:"sendmailpassword",component:PassWordMailComponent},
{path:"forwordPassrord",component:ForgotPassWordComponent},
{path:"changepassword",component:ChangePasswordComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
