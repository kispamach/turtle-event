import React, {Component} from "react";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";

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

class LoginDetails extends Component {

  constructor(props) {
    super(props);
    this.register = this.register.bind(this);
    this.handleLogin = this.handleLogin.bind(this);
    this.onChangeUsername = this.onChangeUsername.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);
  }

    state = {
        username: null,
        password: null,
        loading: false,
        message: ""
    }

    onChangeUsername(e) {
      this.setState({
        username: e.target.value
      });
    }
  
    onChangePassword(e) {
      this.setState({
        password: e.target.value
      });
    }

    handleLogin(e) {
      e.preventDefault();
  
      this.setState({
        message: "",
        loading: true
      });
  
      this.form.validateAll();
  
      if (this.checkBtn.context._errors.length === 0) {
        AuthService.login(this.state.username, this.state.password).then(
          () => {
            this.props.history.push("/profile-page");
            window.location.reload();
          },
          error => {
            const resMessage =
              (error.response &&
                error.response.data &&
                error.response.data.message) ||
              error.message ||
              error.toString();
  
            this.setState({
              loading: false,
              message: resMessage
            });
          }
        );
      } else {
        this.setState({
          loading: false
        });
      }
    }

    register(event) {
      
      const url = "/user/registration/"
      let userData = {        
        email: this.state.email,
        password: this.state.password
      }
      const putMethod = {
        method: 'Post', 
        headers: {
         'Content-type': 'application/json; charset=UTF-8'
        },
        body: JSON.stringify(userData) 
       }
       
       fetch(url, putMethod)
       .then(response => response.json())
       .then(data => console.log(data)) 
       .catch(err => console.log(err))
      event.preventDefault()
      };

    logIn(event) {
      window.location.href="/index";
      event.preventDefault()
    }
  

    render() {
        return(
          <Card className="card-register ml-auto mr-auto">
          <h3 className="title mx-auto">Welcome</h3>
          <div className="social-line text-center">
            <Button
              className="btn-neutral btn-just-icon mr-1"
              color="facebook"
              href="#pablo"
              onClick={(e) => e.preventDefault()}
            >
              <i className="fa fa-facebook-square" />
            </Button>
            <Button
              className="btn-neutral btn-just-icon mr-1"
              color="google"
              href="#pablo"
              onClick={(e) => e.preventDefault()}
            >
              <i className="fa fa-google-plus" />
            </Button>
            <Button
              className="btn-neutral btn-just-icon"
              color="twitter"
              href="#pablo"
              onClick={(e) => e.preventDefault()}
            >
              <i className="fa fa-twitter" />
            </Button>
          </div>
          <Form className="register-form" onSubmit={this.handleLogin} ref={c =>{this.form = c;}}>
            <label>Username</label>
            <Input 
              className="form-control"
              placeholder="Username" 
              name="username" 
              type="text" 
              value={this.state.username} 
              onChange={this.onChangeUsername} 
              validations={[required]} 
            />
            <label>Password</label>
            <Input 
              className="form-control"
              placeholder="Password" 
              name="password" 
              type="password" 
              value={this.state.password} 
              onChange={this.onChangePassword} 
              validations={[required]} 
            />
            {/* <Button block className="btn-round" color="danger" disabled={this.state.loading} onClick={this.logIn}>
              Log In
            </Button> */}
            <button
                className="btn btn-danger btn-block"
                disabled={this.state.loading}
              >
                {this.state.loading && (
                  <span className="spinner-border spinner-border-sm"></span>
                )}
                <span>Login</span>
              </button>

              {this.state.message && (
              <div className="form-group">
                <div className="alert alert-danger" role="alert">
                  {this.state.message}
                </div>
              </div>)}
              <CheckButton
                style={{ display: "none" }}
                ref={c => {
                  this.checkBtn = c;
                }}
              />

          </Form>
          <div className="forgot">
            <Button
              className="btn-link"
              color="danger"
              href="#pablo"
              onClick={(e) => e.preventDefault()}
            >
              Forgot password?
            </Button>
          </div>
        </Card>
        )
    }
}

export default LoginDetails