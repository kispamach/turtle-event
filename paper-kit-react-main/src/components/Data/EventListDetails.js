import React, {Component} from "react";

// reactstrap components
import {Card, CardImg, CardBody, CardTitle, CardText,
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

class EventListDetails extends Component {

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
      let url = '/event/' + this.props.event.id
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
            <Col className="ml-auto mr-auto" md="4">
                <Card style={{width: '20rem'}}>
                    <CardImg top src={require("assets/img/login.jpg")
                                .default} alt="..."/>
                    <CardBody>
                        <CardTitle>{this.props.event.name}</CardTitle>
                        {this.props.event.toDate === null || this.props.event.toDate === this.props.event.fromDate ?
                        <CardText>{this.props.event.fromDate}</CardText> :
                        <CardText>{this.props.event.fromDate} - {this.props.event.toDate}</CardText>}
                        <CardText>{this.props.event.location}</CardText>
                        <Button color="primary">Show details</Button>
                    </CardBody>
                </Card>
            </Col>
           
        )
    }
}

export default EventListDetails