import Button from 'react-bootstrap/Button';
import SyntaxHighlighter from 'react-syntax-highlighter';
import { docco } from 'react-syntax-highlighter/dist/esm/styles/hljs';
import {Dropdown} from "react-bootstrap";
export default function Page1() {
        // const codeString = '(num) => num + 1';
        const codeString = '' +
            'https://www.npmjs.com/package/react-syntax-highlighter' +
            '<Button variant="primary">Primary</Button>\n' +
            '<Button variant="secondary">Secondary</Button>\n' +
            '<Button variant="success">Success</Button>\n' +
            '<Button variant="warning">Warning</Button>\n' +
            '<Button variant="danger">Danger</Button>\n' +
            '<Button variant="info">Info</Button>\n' +
            '<Button variant="light">Light</Button>\n' +
            '<Button variant="dark">Dark</Button>\n' +
            '<Button>Link with Button look </Button>\n' +
            '<Button variant="link" href="https://react-bootstrap.netlify.app/docs/components/buttons">Link to button docs...</Button>\n ';
    return(
        <>
            <h2>Page 1 : react bootstrap Button Examples</h2>
            <hr/>
            <Dropdown>
                <Dropdown.Toggle variant="success" id="dropdown-basic">
                    Dropdown Button
                </Dropdown.Toggle>

                <Dropdown.Menu>
                    <Dropdown.Item href="#/action-1">Action</Dropdown.Item>
                    <Dropdown.Item href="#/action-2">Another action</Dropdown.Item>
                    <Dropdown.Item href="#/action-3">Something else</Dropdown.Item>
                </Dropdown.Menu>
            </Dropdown>
            <hr/>
            <Button variant="primary">Primary</Button>
            <Button variant="secondary">Secondary</Button>
            <Button variant="success">Success</Button>
            <Button variant="warning">Warning</Button>
            <Button variant="danger">Danger</Button>
            <Button variant="info">Info</Button>
            <Button variant="light">Light</Button>
            <Button variant="dark">Dark</Button>
            <Button>Link with Button look </Button>
            <Button variant="link" href="https://react-bootstrap.netlify.app/docs/components/buttons">Link to button
                docs...</Button>
            <hr/>
            <h3>Code</h3>
            <hr/>
            <SyntaxHighlighter language="javascript" style={docco}>
                {codeString}
            </SyntaxHighlighter>
        </>
    )
}
