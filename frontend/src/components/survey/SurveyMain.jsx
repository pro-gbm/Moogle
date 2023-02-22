import Button from '../common/Button';
import Option from './Option';

function SurveyMain(props) {
  const { data } = props;

  return (
    <div
      style={{
        width: '80%',
        height: '100%',
        marginTop: '50px',
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'space-between',
        color: '#FFF',
      }}
    >
      <div style={{ fontSize: '2rem', marginLeft: '15%', marginRight: '15%' }}>
        {data.id}. {data.title}
      </div>
      <div
        style={{ marginLeft: '15%', marginRight: '15%', marginBottom: '30px' }}
      >
        {data.description}
      </div>
      <div style={{ minHeight: '75%', maxHeight: '80%' }}>
        {data.options.map((option, index) => (
          <Option key={`${option.id}-${index}`} data={option} />
        ))}
      </div>
      <div
        style={{
          height: '7%',
          marginLeft: '25%',
          marginRight: '25%',
          display: 'flex',
          justifyContent: 'space-around',
          // backgroundColor: '#FFF',
        }}
      >
        <Button
          color="default"
          size="medium"
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
