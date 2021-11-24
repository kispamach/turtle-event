import React, {Component} from "react";

import authHeader from "services/auth-header";

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

class Participants extends Component {
    state = {
        participants: []
    }

    getUserById(id) {
        let url = '/user/profile/' + id
        
        fetch(url, { headers: authHeader() })
            .then(res => res.json())
            .then(json => {
                this.setState({
                    participants: [
                        ...this.state.participants, 
                        {
                            firstName: json.firstName,
                            lastName: json.lastName
                        }
                    ]
                    })
                })            
      }

    getParticipants() {
        let url = '/user-event-role/by-event/' + this.props.eventId
        fetch(url, { headers: authHeader() })
            .then(res => res.json())
            .then(json => {
                console.log(json);
                Array.from(json).map( (userEventRole => this.getUserById(userEventRole.userId)))
                });
    }

    componentDidMount() {
        this.getParticipants()
    }

    render() {
        return (
            <>
                {this.state.participants.map( (user, index) => 
                <Col className="" lg="1" md="4" xs="4">
                        <img 
                            style={{width: "38px"}}
                            alt="..."
                            className="img-circle img-no-padding img-responsive"
                            src={require("assets/img/faces/default-face.jpg")
                                .default} />
                        <h6>
                            <small style={{color: "white"}}>{user.firstName}</small> <br />
                            <small style={{color: "white"}}>{user.lastName}</small>
                        </h6>
                </Col>
                )}
            </>
                )
    }
}


export default Participants