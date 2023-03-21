/** @jsxImportSource @emotion/react */
import { css } from '@emotion/react';

import Button from '../common/Button';
import Option from './Option';

const surveyMain = css({
  width: '80%',
  height: '100%',
  marginTop: '50px',
  display: 'flex',
  flexDirection: 'column',
  justifyContent: 'space-between',
  color: '#FFF',
  '.title': {
    fontSize: '2rem',
    marginLeft: '15%',
    marginRight: '15%',
  },
  '.description': {
    marginLeft: '15%',
    marginRight: '15%',
    marginBottom: '30px',
  },
  '.options': {
    minHeight: '75%',
    maxHeight: '80%',
  },
});

const buttonArea = css({
  height: '7%',
  marginLeft: '25%',
  marginRight: '25%',
  display: 'flex',
  justifyContent: 'space-around',
  alignItems: 'center',
  // backgroundColor: "#FFF",
});

function SurveyMain(props) {
  const { data } = props;

  return (
    <div css={surveyMain}>
      <div className="title">
        {data.id}. {data.title}
      </div>
      <div className="description">{data.description}</div>
      <div className="options">
        {data.options.map((option, index) => (
          <Option key={`${option.id}-${index}`} data={option} />
        ))}
      </div>
      <div css={buttonArea}>
        <Button
          color="warning"
          size="large"
          value="Prev"
          variant="filled"
          iconPosition="back"
        />
        <Button
          color="default"
          size="medium"
          value="Next"
          variant="filled"
          iconPosition="back"
        />
      </div>
    </div>
  );
}

export default SurveyMain;
