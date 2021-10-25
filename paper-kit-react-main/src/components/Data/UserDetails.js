import React, {Component} from "react";

// reactstrap components
import {
    Button,
    Label,
    FormGroup,
    Input,
    NavItem,
    NavLink,
    Nav,
    TabContent,
    TabPane,
    Container,
    Row,
    Col,
  } from "reactstrap";

class UserDetails extends Component {

    state = {
        userName: null,
        firstName: null,
        lastName: null,
        email:null,
        isEdit: false
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

    editing(event) {
      event.preventDefault()
      //fetch
      console.log("Form submitted");
      console.log(this.state.firstName);
    }

    render() {
        return(
            <>
            {this.state.isEdit ?
            <form onSubmit={this.editing}>
            <div className="owner">
              <div className="avatar">
                <img
                  alt="..."
                  className="img-circle img-no-padding img-responsive"
                  src={require("assets/img/faces/joe-gardner-2.jpg").default}
                />
              </div>
              <div className="name">
                <h4 className="title">
                {this.state.userName} <br />
                </h4>
                                 
                  <div class="form-group">
                    <h6 className="description">
                        <input class="form-control" type="text" value={this.state.firstName} onChange={(e) => this.setState({ ...this.state, firstName: e.target.value })} /> 
                    </h6>
                    <h6 className="description">
                        <input class="form-control" type="text" value={this.state.lastName} onChange={(e) => this.setState({ ...this.state, lastName: e.target.value })} /> 
                    </h6>
                    <h6 className="description">{this.state.email}</h6>
                  <div/>                  
                </div>
              </div>
            </div>
            <Row>
            <Col className="ml-auto mr-auto text-center" md="6">
              
              <br />
              <Button className="btn-round" type="submit" color="default" outline onClick={() => this.setState({...this.state, isEdit: false})}>
                <i className="nc-icon nc-cloud-upload-94" /> Save
              </Button>
            </Col>
          </Row>
          </form> 
          :        
          <><div className="owner">
                <div className="avatar">
                  <img
                    alt="..."
                    className="img-circle img-no-padding img-responsive"
                    src={require("assets/img/faces/joe-gardner-2.jpg").default} />
                </div>
                <div className="name">
                  <h4 className="title">
                    {this.state.userName} <br />
                  </h4>
                  {<><h6 className="description">{this.state.firstName} {this.state.lastName}</h6><h6 className="description">{this.state.email}</h6></>}

                </div>
              </div><Row>
                  <Col className="ml-auto mr-auto text-center" md="6">

                    <br />
                    <Button className="btn-round" color="default" outline onClick={() => this.setState({ ...this.state, isEdit: true })}>
                      <i className="fa fa-cog" /> Settings
                    </Button>
                  </Col>
                </Row></>
    }
        </>
        )
    }
}

export default UserDetails