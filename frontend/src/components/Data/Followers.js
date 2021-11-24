import React, {Component} from "react";
import FollowerDetails from "./FollowerDetails";

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

class Followers extends Component {
    state = {
        followers: []
    }

    getUserById(userId) {
        let url = '/user/profile/' + userId
        
        fetch(url, { headers: authHeader() })
            .then(res => res.json())
            .then(json => {
                this.setState({
                    followers: [
                        ...this.state.followers, 
                        {
                            userName: json.userName,
                            firstName: json.firstName,
                            lastName: json.lastName,
                            email:json.email}
                    ]
                    })
                })            
      }

    getFollowers() {
        let url = '/user/profile/' + this.props.userId
        fetch(url, { headers: authHeader() })
            .then(res => res.json())
            .then(json => {
                json.friendOfIds.map( (friendOf => this.getUserById(friendOf)))
                });
    }

    componentDidMount() {
        this.getFollowers()
    }

    render() {
        return (
            <div className="container">
                {this.state.followers.map( (user, index) => 
                <FollowerDetails key={index} index={index} user={user} fSize={this.state.followers.length}/>)}
            </div>
                )
    }
}


export default Followers