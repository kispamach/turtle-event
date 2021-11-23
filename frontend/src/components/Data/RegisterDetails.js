import React, {Component} from "react";

// reactstrap components
import { Button, Card, Form, Input, Container, Row, Col } from "reactstrap";


class RegisterDetails extends Component {

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
        userName: this.state.userName,
        firstName: this.state.firstName,
        lastName: this.state.lastName,      
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
       window.open("/login-page", "_self")
       event.preventDefault()
      };
  

    render() {
        return(
          <Card className="card-register ml-auto mr-auto">
          <h3 className="title mx-auto">Register</h3>
          <Form className="register-form" onSubmit={this.register}>
            <label>Username</label>
            <Input placeholder="Username" type="text" required minLength="3" value={this.state.userName} onChange={(e) => this.setState({ ...this.state, userName: e.target.value })}/>
            <label>First name</label>
            <Input placeholder="First name" type="text" required minLength="3" value={this.state.firstName} onChange={(e) => this.setState({ ...this.state, firstName: e.target.value })}/>
            <label>Last name</label>
            <Input placeholder="Last name" type="text" required minLength="3" value={this.state.lastName} onChange={(e) => this.setState({ ...this.state, lastName: e.target.value })}/>
            <label>Email</label>
            <Input placeholder="Email" type="email" required value={this.state.email} onChange={(e) => this.setState({ ...this.state, email: e.target.value })}/>
            <label>Password</label>
            <Input placeholder="Password" type="password" required minLength="3" value={this.state.password} onChange={(e) => this.setState({ ...this.state, password: e.target.value })}/>
            <Button block className="btn-round" color="danger">
              Register
            </Button>
          </Form>          
        </Card>
        )
    }
}

export default RegisterDetails