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

class Followers extends Component {
    state = {
        followers: []
    }

    getUserById(userId) {
        let url = '/user/profile/' + userId
        console.log(url);
        
        fetch(url)
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
        fetch(url)
            .then(res => res.json())
            .then(json => {
                json.friendOfIds.map( (friendOf => this.getUserById(friendOf)))
                console.log(json.friendOfIds);
                });
    }

    componentDidMount() {
        this.getFollowers()
        console.log("alma " + this.state.followers);
    }

    render() {
        return (
            <div className="container">
                {this.state.followers.map( (user, index) => 
                <FollowerDetails key={index} user={user}/>)}
            </div>
                )
    }
}


export default Followers