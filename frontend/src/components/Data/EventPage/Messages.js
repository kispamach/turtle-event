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

class Messages extends Component {

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
            <Card style={{width: '44rem', height: '9.4rem'}} className="text-center" color="primary">
                <CardHeader style={{borderRadius: "calc(1.25rem - 9px) calc(1.25rem - 9px) 0 0", backgroundColor: "rgba(255, 255, 255, 0.30)"}}>
                    Messages
                </CardHeader>
                <CardBody style={{padding: "10px"}}> 
                    <Row>
                        <Col>
                            <h5>message1</h5>  
                            <h5>message2</h5>
                        </Col>                   
                    </Row>                
                </CardBody>
            </Card>
           
        )
    }
}

export default Messages