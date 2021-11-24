import React, {Component} from "react";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
import { isEmail } from "validator";

import AuthService from "services/AuthService";

// reactstrap components
import { Button, Card, Container, Row, Col } from "reactstrap";


const required = value => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    );
  }
};

const email = value => {
  if (!isEmail(value)) {
    return (
      <div className="alert alert-danger" role="alert">
        This is not a valid email.
      </div>
    );
  }
};

const vusername = value => {
  if (value.length < 3 || value.length > 20) {
    return (
      <div className="alert alert-danger" role="alert">
        The username must be between 3 and 20 characters.
      </div>
    );
  }
};

const vfirstname = value => {
  if (value.length < 3 || value.length > 20) {
    return (
      <div className="alert alert-danger" role="alert">
        The firstname must be between 3 and 20 characters.
      </div>
    );
  }
};

const vlastname = value => {
  if (value.length < 3 || value.length > 20) {
    return (
      <div className="alert alert-danger" role="alert">
        The lastname must be between 3 and 20 characters.
      </div>
    );
  }
};

const vpassword = value => {
  if (value.length < 6 || value.length > 40) {
    return (
      <div className="alert alert-danger" role="alert">
        The password must be between 6 and 40 characters.
      </div>
    );
  }
};

class RegisterDetails extends Component {

  constructor(props) {
    super(props);
    // this.register = this.register.bind(this);
    this.handleRegister = this.handleRegister.bind(this);
    this.onChangeUsername = this.onChangeUsername.bind(this);
    this.onChangeFirstName = this.onChangeFirstName.bind(this);
    this.onChangeLastName = this.onChangeLastName.bind(this);
    this.onChangeEmail = this.onChangeEmail.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);  

    this.state = {
        username: "",
        firstName: "",
        lastName: "",
        email:"",
        password: "",
        successful: false,
        message: ""
    }
  }

  onChangeUsername(e) {
    this.setState({
      username: e.target.value
    });
  }

  onChangeFirstName(e) {
    this.setState({
      firstName: e.target.value
    });
  }

  onChangeLastName(e) {
    this.setState({
      lastName: e.target.value
    });
  }

  onChangeEmail(e) {
    this.setState({
      email: e.target.value
    });
  }

  onChangePassword(e) {
    this.setState({
      password: e.target.value
    });
  }

  handleRegister(e) {
    e.preventDefault();

    this.setState({
      message: "",
      successful: false
    });

    this.form.validateAll();

    if (this.checkBtn.context._errors.length === 0) {
      AuthService.register(
        this.state.username,
        this.state.firstName,
        this.state.lastName,
        this.state.email,
        this.state.password
      ).then(
        response => {
          this.setState({
            message: response.data.message,
            successful: true
          });
        },
        error => {
          const resMessage =
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString();

          this.setState({
            successful: false,
            message: resMessage
          });
        }
      );
    }
  }

    // register(event) {      
    //   const url = "/user/registration/"
    //   let userData = {  
    //     userName: this.state.userName,
    //     firstName: this.state.firstName,
    //     lastName: this.state.lastName,      
    //     email: this.state.email,
    //     password: this.state.password
    //   }
    //   const putMethod = {
    //     method: 'Post', 
    //     headers: {
    //      'Content-type': 'application/json; charset=UTF-8'
    //     },
    //     body: JSON.stringify(userData) 
    //    }
       
    //    fetch(url, putMethod)
    //    .then(response => response.json())
    //    .then(data => console.log(data)) 
    //    .catch(err => console.log(err))
    //    window.open("/login-page", "_self")
    //    event.preventDefault()
    //   };
  

    render() {
        return(
          <Card className="card-register ml-auto mr-auto">
          <h3 className="title mx-auto">Register</h3>
          <Form className="register-form" onSubmit={this.handleRegister}
            ref={c => {
              this.form = c;
            }}
          >
            {!this.state.successful && (
            <div>
              <label>Username</label>
              <Input 
                placeholder="Username" 
                className="form-control"
                name="username"
                type="text"
                value={this.state.username} 
                onChange={this.onChangeUsername}
                validations={[required, vusername]} 
              />
              <label>First name</label>
              <Input 
                placeholder="First name" 
                type="text" 
                className="form-control"
                name="firstname"
                value={this.state.firstName} 
                onChange={this.onChangeFirstName}
                validations={[required, vfirstname]} 
              />
              <label>Last name</label>
              <Input 
                placeholder="Last name" 
                type="text"
                className="form-control"
                name="lastname"
                value={this.state.lastName} 
                onChange={this.onChangeLastName}
                validations={[required, vlastname]} 
              />
              <label>Email</label>
              <Input 
                placeholder="Email" 
                type="email"
                className="form-control"
                name="email"
                value={this.state.email} 
                onChange={this.onChangeEmail}
                validations={[required, email]}
              />
              <label>Password</label>
              <Input 
                placeholder="Password" 
                type="password" 
                className="form-control"
                name="password"
                value={this.state.password} 
                onChange={this.onChangePassword}
                validations={[required, vpassword]}
              />
              
              <div className="form-group">
                  <button className="btn btn-danger btn-block btn-round">Register</button>
                </div>
            </div>
            )}

            {this.state.message && (
              <div className="form-group">
                <div
                  className={
                    this.state.successful
                      ? "alert alert-warning"
                      : "alert alert-warning"
                  }
                  role="alert"
                >
                  {this.state.message}
                </div>
              </div>
            )}
            <CheckButton
              style={{ display: "none" }}
              ref={c => {
                this.checkBtn = c;
              }}
            />
          </Form>          
        </Card>
        )
    }
}

export default RegisterDetails