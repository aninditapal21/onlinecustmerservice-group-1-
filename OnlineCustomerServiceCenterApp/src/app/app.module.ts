import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponentComponent } from './login-component/login-component.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MenuComponent } from './menu/menu.component';
import { DepartmentComponent } from './department/department.component';
import { LogoutComponent } from './logout/logout.component';
import { CustomerComponent } from './customer/customer.component';
import { ViewDepartmentComponent } from './view-department/view-department.component';
import { UpdateFormComponent } from './update-form/update-form.component';
import { FindDepartmentComponent } from './find-department/find-department.component';
import { OperatorMenuComponent } from './operator-menu/operator-menu.component';
import { IssueComponent } from './issue/issue.component';
import { ViewIssueComponent } from './view-issue/view-issue.component';
import { UpdateIssueFormComponent } from './update-issue-form/update-issue-form.component';
import { FindCustmerComponent } from './find-custmer/find-custmer.component';
import { ViewCustomerComponent } from './view-customer/view-customer.component';
import { MailComponent } from './mail/mail.component';
import { LockCustomerComponent } from './lock-customer/lock-customer.component';
import { IntimationMailComponent } from './intimation-mail/intimation-mail.component';
import { ViewOperatorComponent } from './view-operator/view-operator.component';
import { FindOperatorComponent } from './find-operator/find-operator.component';
import { HomeComponent } from './home/home.component';
import { UpdateOperatorComponent } from './update-operator/update-operator.component';
import { OperatorComponent } from './operator/operator.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { CustomerviewissueComponent } from './customerviewissue/customerviewissue.component';
import { FindIssueComponent } from './find-issue/find-issue.component';
import { PassWordMailComponent } from './pass-word-mail/pass-word-mail.component';
import { ForgotPassWordComponent } from './forgot-pass-word/forgot-pass-word.component';
import { ChangePasswordComponent } from './change-password/change-password.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponentComponent,
    MenuComponent,
    DepartmentComponent,
    LogoutComponent,
    CustomerComponent,
    ViewDepartmentComponent,
    UpdateFormComponent,
    FindDepartmentComponent,
    OperatorMenuComponent,
    IssueComponent,
    ViewIssueComponent,
    UpdateIssueFormComponent,
    FindCustmerComponent,
    ViewCustomerComponent,
    MailComponent,
    LockCustomerComponent,
    IntimationMailComponent,
    ViewOperatorComponent,
    FindOperatorComponent,
    HomeComponent,
    UpdateOperatorComponent,
    OperatorComponent,
    WelcomeComponent,
    CustomerviewissueComponent,
    FindIssueComponent,
    PassWordMailComponent,
    ForgotPassWordComponent,
    ChangePasswordComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
