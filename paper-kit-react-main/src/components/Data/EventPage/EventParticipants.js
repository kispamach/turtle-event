import React, {Component} from "react";
import Participants from "./Participants";

// reactstrap components
import {Card, CardImg, CardHeader,CardBody, CardTitle, CardText,
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

class EventParticipants extends Component {

  constructor(props) {
    super(props);
  }

    state = {
        name: null,
        description: null,
        location: null,
        fromDate: null,
        toDate: null,
        createTime: false
    }

    getEventById() {
      let url = '/event/' + this.props.eventId
        fetch(url)
            .then(res => res.json())
            .then(json => {
                this.setState({
                    name: json.name,
                    description: json.description,
                    location: json.location,
                    fromDate: json.fromDate,
                    toDate: json.toDate,
                    createTime: json.createTime})
                });
    }

    componentDidMount() {
        this.getEventById()
    } 


    render() {
        return(
            <Card style={{width: '67.6rem'}} className="text-center" color="danger">
                <CardHeader style={{borderRadius: "calc(1.25rem - 9px) calc(1.25rem - 9px) 0 0", backgroundColor: "rgba(255, 255, 255, 0.30)"}}>
                    Participants
                </CardHeader>
                <CardBody style={{padding: "10px"}}> 
                    <Row className="justify-content-md-center">                       
                        <Participants eventId="2"/>  
                    </Row>                
                </CardBody>
            </Card>
           
        )
    }
}

export default EventParticipants