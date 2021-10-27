import React, {Component} from "react";

// reactstrap components
import { Button, Card, Form, Input, Container, Row, Col } from "reactstrap";


class LoginDetails extends Component {

  constructor(props) {
    super(props);
    this.register = this.register.bind(this);
  }

    state = {
        userName: null,
        firstName: null,
        lastName: null,
        email:null,
        password: null
    }

    getUserById() {
      let url = '/user/profile/' + this.props.userId
        fetch(url)
            .then(res => res.json())
            .then(json => {
                this.setState({
                    userName: json.userName,
                    firstName: json.firstName,
                    lastName: json.lastName,
                    email:json.email})
                });
    }

    componentDidMount() {
        this.getUserById()
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
      console.log("password: " + this.state.password);
      console.log(this.state.email);
       event.preventDefault()
      };
  

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
          <Form className="register-form" onSubmit={this.register}>
            <label>Email</label>
            <Input placeholder="Email" type="email" required value={this.state.email} onChange={(e) => this.setState({ ...this.state, email: e.target.value })}/>
            <label>Password</label>
            <Input placeholder="Password" type="password" required value={this.state.password} onChange={(e) => this.setState({ ...this.state, password: e.target.value })}/>
            <Button block className="btn-round" color="danger" href="/index">
              Log In
            </Button>
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