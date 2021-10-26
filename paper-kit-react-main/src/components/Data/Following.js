import React, {Component} from "react";
import FollowerDetails from "./FollowerDetails";

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

class Following extends Component {
    state = {
        following: []
    }

    getUserById(userId) {
        let url = '/user/profile/' + userId
        
        fetch(url)
            .then(res => res.json())
            .then(json => {
                this.setState({
                    following: [
                        ...this.state.following, 
                        {
                            userName: json.userName,
                            firstName: json.firstName,
                            lastName: json.lastName,
                            email:json.email}
                    ]
                    })
                })            
      }

    getFollowing() {
        let url = '/user/profile/' + this.props.userId
        fetch(url)
            .then(res => res.json())
            .then(json => {
                json.friendIds.map( (friendOf => this.getUserById(friendOf)))
                });
    }

    componentDidMount() {
        this.getFollowing()
    }

    render() {
        return (
            <div className="container">
                {this.state.following.map( (user, index) => 
                <FollowerDetails key={index} index={index} user={user} fSize={this.state.following.length}/>)}
            </div>
                )
    }
}


export default Following